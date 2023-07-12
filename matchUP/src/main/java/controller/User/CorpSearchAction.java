package controller.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CorpSearch")
public class CorpSearchAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
    }


}

//response.setCharacterEncoding("utf-8");
//response.setContentType("application/json; charset=utf-8");
//
//HttpSession session = request.getSession();
//
//if(session.getAttribute("log") == null) {
//	response.sendRedirect("login");
//} else {
//	// 1. 파라미터 값으로 검색어를 들고  
//	// 2. 다음 API로 책 검색 요청 
//	// 3. 스트링으로 받은 응답값을 
//	// 4. JSON Object로 변환하여 처리 
//	// 5. JSON Array 형태로 검색된 책 목록을 -> 반환 (response) 
//	
//	String keyword = request.getParameter("query");
//	
//	if(keyword != null) {
//		String location = "https://dapi.kakao.com/v3/search/book?query=" + URLEncoder.encode(keyword, "utf-8");
//		
//		URL url = new URL(location);
//		
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Authorization", "KakaoAK d040acfc98498baa399bffccd7ebfa65");
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		
//		String result = "";
//		while(br.ready()) {
//			String line = br.readLine() + "\n";
//			result += line;
//		}			
//		
//		br.close();
//		conn.disconnect();
//		
//		// *결과물로 -> JSONObject 만들기 
//		JSONObject jsonObj = new JSONObject(result);	// {meta : Meta, documents : []}
//		JSONArray list = new JSONArray(jsonObj.get("documents").toString());
//		System.out.println("list.length() : " + list.length());
//		
//		ArrayList<BookResponseDto> bookList = new ArrayList<BookResponseDto>();
//		
//		for(int i=0; i<list.length(); i++) {
//			JSONObject book = new JSONObject(list.get(i).toString());
//			
//			String thumbnail = book.getString("thumbnail");
//			String title = book.getString("title");
//			
//			JSONArray authorList = new JSONArray(book.get("authors").toString());
//			String author = authorList.length() > 0 ? authorList.getString(0) : "";
//			
//			String publisher = book.getString("publisher");
//			int price = book.getInt("sale_price");
//			
//			BookResponseDto bookDto = new BookResponseDto(thumbnail, title, author, publisher, price);
//			bookList.add(bookDto);
//		}
//		
//		JSONArray responseList = new JSONArray(bookList);
//		response.getWriter().append(responseList.toString());
//		
//	} else {
//		response.sendRedirect("booklist");
//	}
//	
//}
//
//}
//
//}
