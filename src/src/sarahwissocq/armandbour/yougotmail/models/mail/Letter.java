package src.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Content;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;

public abstract class Letter<T extends Content> implements Mail<T> {

		/** Content of the letter */
		protected T content;
		
		/** The inhabitant who send the letter */
		protected Inhabitant sender;
		
		/** The inhabitant who will receive the letter */
		protected Inhabitant receiver;
		
		public Letter(Inhabitant sender, Inhabitant receiver,T content){
			
		}
		
		/**
		 * Return the sender of the letter
		 */
		public Inhabitant getSender(){
			return this.sender;
		}
		
		/**
		 * Return the receiver of the letter
		 */
		public Inhabitant getReceiver(){
			return this.receiver;
		}
		
		public abstract float getCost();
		
		public abstract void action();
}
