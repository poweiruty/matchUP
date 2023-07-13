package controller.corp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JobPost.JobPost;
import model.JobPost.JobPostDto;
import model.region.MainRegion;
import model.region.RegionDao;
import model.region.SemiRegion;
import model.user_corp.CorpUser;
import model.user_corp.CorpUserDao;
import util.DBManager;

/**
 * Servlet implementation class SearchAction
 */
@WebServlet("/Search")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String job = request.getParameter("job");
		String region = request.getParameter("region");
		CorpUserDao dao = CorpUserDao.getInstance();
		ArrayList<JobPostDto> list = null;
		RegionDao reDao = RegionDao.getInstance();
		ArrayList<SemiRegion> selist = new ArrayList<SemiRegion>();
		
		
		String[] cname = null;
		String jobName = null;
		//String[] main_region = null;
		String main_region = null;
		String[] semi_region = null;
		
//		if(dao.getUserbyCname(job) != null) {
//			list = dao.getUserbyCname(job);
//			cname = new String[list.size()];
//			for(int i = 0; i < cname.length; i++) {
//				cname[i] = list.get(i).getCname();
//			}
//			
//			System.out.println(Arrays.toString(cname));
//		}
		
//		if(reDao.getMainbySearch(region) != null) {
//			mrlist = reDao.getMainbySearch(region);
//			main_region = new String[mrlist.size()];
//			for(int i = 0; i < main_region.length; i++) {
//				main_region[i] = mrlist.get(i).getMainRegion();
//			}
//			System.out.println(Arrays.toString(main_region));
//		}

		if(reDao.getMainbySearch(region) != null) {
			main_region = reDao.getMainbySearch(region);
			int mrid = Integer.parseInt(main_region);
			selist = reDao.getSemibySearch(mrid);
			semi_region = new String[selist.size()];
			for(int i = 0; i < selist.size(); i++) {
				semi_region[i] = selist.get(i).getSemiRegion();
			}
			//System.out.println(Arrays.toString(semi_region));			
		}
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		
		
		
		
		if(job.equals("") && !region.equals("")) {			
			if(main_region != null) {
				//System.out.println("지역만 ");
				list = new ArrayList<JobPostDto>();
				conn = DBManager.getConnection();
				if(conn != null) {
					String sql = "select * from job_posting_tb where main_region_id=?";
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(main_region));
						rs = pstmt.executeQuery();
						while(rs.next()) {
							String name = rs.getString(2);
							String staffs = rs.getString(3);
							String ceo = rs.getString(4);
							String rpeo = rs.getString(8);
							String rper = rs.getString(9);
							String salary = rs.getString(10);
							String welfare = rs.getString(11);
							String desc = rs.getString(12);

							JobPostDto post = new JobPostDto(name, staffs, ceo, rpeo, rper, salary, welfare, desc);
							
							list.add(post);
						}
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						DBManager.close(conn, pstmt, rs);
					}
				}	
				for(JobPostDto post : list) {
					System.out.println(post);
				}
			}
			
		}else if(!job.equals("") && region.equals("")) {			
			System.out.println("직업만");
		}else if(job.equals("") && region.equals("")) {
			System.out.println("둘다빈칸");
		}else {
//			conn = DBManager.getConnection();
//			if(conn != null) {
//				String sql = "select * from job_posting_tb where ";
//			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
