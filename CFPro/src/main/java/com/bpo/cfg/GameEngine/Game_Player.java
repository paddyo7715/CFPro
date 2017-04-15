package com.bpo.cfg.GameEngine;


public abstract class Game_Player {

		protected String Position;
		protected String Number;
		protected int PlayerNumber;
		protected String FirstName;
		protected String LastName;
		protected int Image;
		private int FieldPositionX;
		private int FieldPositionY;

		public Game_Player(String Position, String Number, int PlayerNumber, String FirstName, String LastName)
		{
			this.Position = Position;
			this.Number = Number;
			this.PlayerNumber = PlayerNumber;
			this.FirstName = FirstName;
			this.LastName = LastName;
		}
		
		public String getPosition() {
			return Position;
		}

		public String getNumber() {
			return Number;
		}

		public int getPlayerNumber() {
			return PlayerNumber;
		}

		public String getFirstName() {
			return FirstName;
		}

		public String getLastName() {
			return LastName;
		}

		public int getImage() {
			return Image;
		}

		public void setImage(int image) {
			Image = image;
		}

		public int getFieldPositionX() {
			return FieldPositionX;
		}

		public void setFieldPositionX(int fieldPositionX) {
			FieldPositionX = fieldPositionX;
		}

		public int getFieldPositionY() {
			return FieldPositionY;
		}

		public void setFieldPositionY(int fieldPositionY) {
			FieldPositionY = fieldPositionY;
		}
		
}


