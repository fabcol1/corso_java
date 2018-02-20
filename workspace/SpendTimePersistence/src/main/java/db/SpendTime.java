package db;

public class SpendTime {

		private int id;
		private String data;
		private int ora;
		
		public SpendTime() {
			
		}
		
		public SpendTime(int id, String data, int ora) {
			this.id = id;
			this.data = data;
			this.ora = ora;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public int getOra() {
			return ora;
		}
		public void setOra(int ora) {
			this.ora = ora;
		}
		
		
	}

