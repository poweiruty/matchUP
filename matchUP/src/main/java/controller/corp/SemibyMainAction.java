package controller.corp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.region.RegionDao;
import model.region.SemiRegion;
import model.region.SemiRegionRequestDto;

/**
 * Servlet implementation class SemibyMainAction
 */
public class SemibyMainAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemibyMainAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("application/json; charset=utf-8");	
		
		String main = request.getParameter("main");
		ArrayList<SemiRegion> list = null;
		RegionDao dao = RegionDao.getInstance();
		
		if(main != null && dao.getSemibyMain(main) != null) {
			System.out.println("main : " + main);
			list = dao.getSemibyMain(main);			
		}
		
		if(list != null) {
			ArrayList<SemiRegionRequestDto> semiList = new ArrayList<SemiRegionRequestDto>();
			for(SemiRegion semi : list) {
				
				int main_region_id = semi.getMainRegionId();
				String semi_region = semi.getSemiRegion();				
				
				SemiRegionRequestDto dto = new SemiRegionRequestDto(main_region_id, semi_region);
				semiList.add(dto);
			}
			
			JSONArray responseList = new JSONArray(semiList);
			response.getWriter().append(responseList.toString());
		}else
			response.sendRedirect("search");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
