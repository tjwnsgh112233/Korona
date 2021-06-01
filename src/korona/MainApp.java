package korona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import JDBC.JDBC;
import VO.KoronaVO;


public class MainApp {
	
	public static void main(String[] args) throws Exception {
		
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=14&ncvContSeq=&contSeq=&board_id=&gubun";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("td");
		
		String A = elem.select("td").text();
		String Thailand_Confirmation = elem.select("td").text().substring(117, 124);
		String Thailand_Dead = elem.select("td").text().substring(130, 135);
		
		
		System.out.println(A);
		System.out.println(Thailand_Confirmation);	//확진자
		System.out.println(Thailand_Dead);	//사망자
	}
	
	Connection conn = null;
	ResultSet rs=  null;
	PreparedStatement stmt = null;
	
	public int add(KoronaVO K) {
		int cnt = 0;
		
		try {
			
			conn = JDBC.getConnection();
			String sql = "insert into a values(?,?,?) ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, K.getName());
			stmt.setString(2, K.getConfirmation());
			stmt.setString(3, K.getDead());
			
			cnt = stmt.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(stmt, conn);
		}
		return cnt;
	}
	
	public KoronaVO K() throws Exception{
		String URL = "http://ncov.mohw.go.kr/";
		Document doc = Jsoup.connect(URL).get();
		Element elem = doc.selectFirst("span.num:nth-child(1)");
		
		String A = "http://ncov.mohw.go.kr/";
		Document D = Jsoup.connect(A).get();
		Elements elem1 = D.select("span.num:nth-child(1)");
		
		String Confirmation = elem.select("span").text();
		String Dead = elem1.select("span").text().substring(22, 27);
		
		System.out.println(Confirmation);	//확진자
		System.out.println(Dead);			//사망자
		
		KoronaVO K = new KoronaVO();
		
		K.setConfirmation(Confirmation);
		K.setDead(Dead);
		
		System.out.println(K);
		return K;
	}
	
	public KoronaVO china() throws Exception{
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=14&ncvContSeq=&contSeq=&board_id=&gubun";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("td");
		
		String China_Confirmation = elem.select("td").text().substring(3, 9);
		String China_Dead = elem.select("td").text().substring(15, 20);
		
		KoronaVO C = new KoronaVO();
		
		C.setConfirmation(China_Confirmation);
		C.setDead(China_Dead);
		
		return C;
	}

	public KoronaVO Japan() throws Exception{
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=14&ncvContSeq=&contSeq=&board_id=&gubun";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("td");
		
		String Japan_Confirmation = elem.select("td").text().substring(72, 79);
		String Japan_Dead = elem.select("td").text().substring(85, 91);
		
		KoronaVO J = new KoronaVO();
		
		J.setConfirmation(Japan_Confirmation);
		J.setDead(Japan_Dead);
		return J;
	}
	
	public KoronaVO Hong_Kong() throws Exception{
		
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=14&ncvContSeq=&contSeq=&board_id=&gubun";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("td");
		
		String Hong_Kong_Confirmation = elem.select("td").text().substring(25, 31);
		String Hong_Kong_Dead = elem.select("td").text().substring(37, 40);
		
		KoronaVO H = new KoronaVO();
		
		H.setConfirmation(Hong_Kong_Confirmation);
		H.setDead(Hong_Kong_Dead);
		return H;
	}
	
	public KoronaVO Taiwan() throws Exception{
		
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=14&ncvContSeq=&contSeq=&board_id=&gubun";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("td");
		
		String Taiwan_Confirmation = elem.select("td").text().substring(45, 50);
		String Taiwan_Dead = elem.select("td").text().substring(56, 59);
		
		KoronaVO T = new KoronaVO();
		
		T.setConfirmation(Taiwan_Confirmation);
		T.setDead(Taiwan_Dead);
		return T;
	}
	
	public KoronaVO Singapore() throws Exception{
		
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=14&ncvContSeq=&contSeq=&board_id=&gubun";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("td");
		
		String Singapore_Confirmation = elem.select("td").text().substring(98, 104);
		String Singapore_Dead = elem.select("td").text().substring(110, 112);
		
		KoronaVO S = new KoronaVO();
		
		S.setConfirmation(Singapore_Confirmation);
		S.setDead(Singapore_Dead);
		return S;
	}
	
	public KoronaVO Thailan() throws Exception{
		
		String URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=14&ncvContSeq=&contSeq=&board_id=&gubun";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("td");
		
		String Thailand_Confirmation = elem.select("td").text().substring(117, 124);
		String Thailand_Dead = elem.select("td").text().substring(130, 135);
		
		KoronaVO T = new KoronaVO();
		
		T.setConfirmation(Thailand_Confirmation);
		T.setDead(Thailand_Dead);
		return T;
	}

	
}