*** Simulation de distribution de courrier dans une ville ***
*** Armand BOUR, Sarah WISSOCQ ***
*** 23/11/2014 ***

Ce programme simule une distribution de courrier entre les habitants d'une ville, possédant chacun un compte bancaire où des retraits et des
dépôts sont effectués, sur un nombre de jours choisi.
Il a pour but l'explication du principe d'ouvert/fermé, étant donné qu'il a été demandé d’implémenter trois versions, chacune comportant des
ajouts par rapport aux versions précédentes.

Exécution : java -jar tp03-bour-armand-wissocq-sarah.jar [nombre de jours (optionnel)]


** Interfaces et méthodes polymorphiques **

* Interface Content
	
	Interface représentant le contenu d'une lettre. Elle permet de restreindre le type paramétré utilisé dans l'interface Mail<T>.


	- Méthode "public Object get()"

		Elle permet d'obtenir l'objet associé avec le contenu.
		Par exemple, pour un Content de type Money, on y renverra le flottant représentant la somme contenue.


* Interface Mail<T extends Content>

	Interface représentant une lettre. Elle possède un type paramétré implémentant Content, représentant le contenu de la lettre (un texte, de l'argent, etc).

	Elle possède quatre accesseurs permettant d'obtenir l'expéditeur, le destinataire, le coût, et le contenu (renvoie le type paramétré T) ; ainsi qu'une méthode action() représentant le code à exécuter à l'ouverture de la lettre.


* Interface UIListener *

	Interface représentant un listener contenant des méthodes appelées lorsque certains événements surviennent pendant l'exécution (reception d'un courrier, débit sur un compte bancaire).

	Une classe implémentant cette interface peut alors choisir d'afficher des informations lors de la survenue de ces événements.


** Codes samples **

* Content *

	L'interface Content possède une méthode "public Object get()". Cette méthode présente plusieurs implémentations polymorphiques, pusique lors de sa surcharge, il est possible de renvoyer n'importe quel type d'objet.

	// Classe Money

	/** The amount of money contained. */
	private float amount;
	
	[...]

	@Override
	public Float get() {
		return this.amount;
	}

	// Classe Text

	/** The text contained. */
	private String text;
	
	@Override
	public String get() {
		return this.text;
	}

	L'ajout de cette méthode permet d'éviter tout cast de l'attribut de type Content dans la classe Letter avant de pouvoir accéder à l'objet associé au contenu (la somme ou le texte dans les exemples ci-dessus).

* DecorativeLetter *

	La classe abstraite DecorativeLetter est impliquée dans le "decorator pattern". Il s'agit d'une lettre contenant une autre lettre, afin de modéliser la possibilité de créer une lettre recommandée ou urgente (classes RegisteredLetter ou UrgentLetter).

	// Constructeur de DecorativeLetter
	public DecorativeLetter(Letter<?> letter) {
		/* On passe en paramètre la lettre à transformer, et on la stocke dans le champs this.content (issu de l'héritage avec Letter) */
		super(letter.sender, letter.receiver, letter);
	}

	// Méthode action de DecorativeLetter
	@Override
	public void action() {
		// Appel à la méthode action de la lettre contenue
		this.content.action();
	}

	Et par exemple, dans la classe RegisteredLetter (lettre recommandée) :

	@Override
	public void action() {
		// Appel à la méthode action de la lettre contenue
		super.action();
		// Envoi d'un accusé de réception
		this.receiver.postMail(new AcknowledgmentOfReceipt(this.receiver,
				this.sender));
	}


* Affichage chaîné du contenu d'une lettre *

	Dans la trace d'exécution, le type de la lettre et son contenu est affiché (par exemple : "an urgent letter whose content is a simple letter whose content is a text content (blah blah blah mr. freeman)"), la méthode toString() a été surchargée dans toutes les classes héritant de Letter et de Content afin de pouvoir l'appeler de façon chaînée.

	// Surcharge de toString() dans SimpleLetter
	@Override
	public String toString() {
		return "a simple letter whose content is " + this.content.toString();
	}

	// Surcharge de toString() dans UrgentLetter
	@Override
	public String toString() {
		/* Appel à la méthode toString() de la lettre contenue, qui se chargera elle-même d'appeler la méthode du contenu */
		return "an urgent letter whose content is " + this.content.toString();
	}

* Listener *

	L'interface UIListener permet d'éviter d'hardcode des affichages sur la sortie standards dans le model. La classe City contient un attribut de type UIListener, qui recevra les notifications d'événement.

	// Méthode receiveMail de la classe Inhabitant
	public void receiveMail(Mail<?> l){
		UIListener listener = this.city.getListener();
		if(listener != null)
			// Notification auprès du listener s'il existe
			listener.onReceivingMail(l);
		
		l.action();
	}

	Puis, dans une classe UIConsole implémentant UIListener :

	// Méthode appelée à chaque réception de mail par un habitant
	@Override
	public void onReceivingMail(Mail<?> mail) {
		// Affichage d'information sur l'événement
		this.printer.printf("-> %s receives %s from %s.%n",
				mail.getSender(), mail, mail.getReceiver());
	}


	On centralise ainsi tout affichage dans une classe séparée.