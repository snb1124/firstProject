package a.b.c.com.ksj.book.vo;

public class BookVO {

		private String knum;
		private String ktitle;
		private String kauth;
		private String isbn;
		private String kcomp;
		private String kprice;
		private String kqty;
		private String kcover;
		private String deleteyn;
		private String insertdate;
		private String updatedate;
		
		public BookVO(){
			
			
		}
		
		
		
		public BookVO(String knum, String ktitle, String kauth, String isbn, String kcomp, String kprice, String kqty,
				String kcover, String deleteyn, String insertdate, String updatedate) {
			
			this.knum = knum;
			this.ktitle = ktitle;
			this.kauth = kauth;
			this.isbn = isbn;
			this.kcomp = kcomp;
			this.kprice = kprice;
			this.kqty = kqty;
			this.kcover = kcover;
			this.deleteyn = deleteyn;
			this.insertdate = insertdate;
			this.updatedate = updatedate;
		}
		public String getKnum() {
			return knum;
		}
		public void setKnum(String knum) {
			this.knum = knum;
		}
		public String getKtitle() {
			return ktitle;
		}
		public void setKtitle(String ktitle) {
			this.ktitle = ktitle;
		}
		public String getKauth() {
			return kauth;
		}
		public void setKauth(String kauth) {
			this.kauth = kauth;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getKcomp() {
			return kcomp;
		}
		public void setKcomp(String kcomp) {
			this.kcomp = kcomp;
		}
		public String getKprice() {
			return kprice;
		}
		public void setKprice(String kprice) {
			this.kprice = kprice;
		}
		public String getKqty() {
			return kqty;
		}
		public void setKqty(String kqty) {
			this.kqty = kqty;
		}
		public String getKcover() {
			return kcover;
		}
		public void setKcover(String kcover) {
			this.kcover = kcover;
		}
		public String getDeleteyn() {
			return deleteyn;
		}
		public void setDeleteyn(String deleteyn) {
			this.deleteyn = deleteyn;
		}
		public String getInsertdate() {
			return insertdate;
		}
		public void setInsertdate(String insertdate) {
			this.insertdate = insertdate;
		}
		public String getUpdatedate() {
			return updatedate;
		}
		public void setUpdatedate(String updatedate) {
			this.updatedate = updatedate;
		}
		
		public static void printBookVO(BookVO bvo){
			System.out.print(bvo.getKnum());
			System.out.print(bvo.getKtitle());
			System.out.print(bvo.getKauth());
			System.out.print(bvo.getIsbn());
			System.out.print(bvo.getKcomp());
			System.out.print(bvo.getKprice());
			System.out.print(bvo.getKqty());
			System.out.print(bvo.getKcover());
			System.out.print(bvo.getDeleteyn());
			System.out.print(bvo.getInsertdate());
			System.out.print(bvo.getUpdatedate());
		}
		public static void printlnBookVO(BookVO bvo){
			System.out.println(bvo.getKnum());
			System.out.println(bvo.getKtitle());
			System.out.println(bvo.getKauth());
			System.out.println(bvo.getIsbn());
			System.out.println(bvo.getKcomp());
			System.out.println(bvo.getKprice());
			System.out.println(bvo.getKqty());
			System.out.println(bvo.getKcover());
			System.out.println(bvo.getDeleteyn());
			System.out.println(bvo.getInsertdate());
			System.out.println(bvo.getUpdatedate());
		}
	
}
