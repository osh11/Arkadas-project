package com.kh.diagnosis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberNutrition;

/**
 * Servlet implementation class DiagnosisResultServlet
 */
@WebServlet("/result.di")
public class DiagnosisResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosisResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nButton[]=request.getParameterValues("nutrious");
		int[] nutrious=new int[12];
		HashMap<String,String> document=new HashMap<>();
		HashMap<String,Integer> set=new HashMap<>();
		
		String [] button2=new String[4];
		button2[1]=request.getParameter("button11");
		button2[2]=request.getParameter("button22");
		button2[3]=request.getParameter("button33");
		
		
		int[] nutrious2=new int[4];
		nutrious2[1]=Integer.parseInt(button2[1]);
		nutrious2[2]=Integer.parseInt(button2[2]);
		nutrious2[3]=Integer.parseInt(button2[3]);
		
		document.put("프로바이오틱스","<br>프로바이오틱스<br><br> #장 건강에 좋은 효능<br> #유익한 유산균 증식과 장내 세균 억제<br> #배변활동을 원활히 도와 변비에 좋은 성분");
		document.put("비타민C","<br>비타민C<br><br> #결합조직 형성과 기능유지에 필요<br> #철의 흡수에 필요<br> #피부, 잇몸 건강 항상화 물질로 신체를 보호<br> #정상적인 면역기능에 필요 <br> #정상적인 세포 분열에 필요");
		if(nutrious2[1]!=1)
			document.put("비타민A","<br>비타민A<br><br> #피부에 작용하는 항산화 및 세포 기능 개선 성분<br> #시력을 보호하고 세포 재생을 촉진<br> #신체의 저항력을 강화시켜 면역 기능을 증진 <br> #강력한 항산화 작용");
		document.put("루테인","<br>루테인<br><br> # 강력한 항산화 효능 <br> #안구건조증, 노안, 녹내장 예방 등에 탁월<br> #과다 섭취 시 오히려 황반변성의 위험성이 높아지니 주의");
		document.put("오메가3","<br>오메가3<br><br> #두뇌발달성분 <br> #혈액순환에 도움<br> #DHA 성분으로 건조한 눈을 개선해 눈 건강에 도움<br> #EPA 성분으로 혈중 중성지방(콜레스테롤)의 합성을 방해");
		if(nutrious2[2]!=1)
			document.put("비타민B","<br>비타민B<br><br> #단백질 및 아미노산 이용에 필요<br> #면역력 강화<br> #혈액의 호모시스테인 수준을 정상으로 유지<br> #체내 에너지 생성에 필요<br> #정상적인 엽산 대사에 필요");
		document.put("밀크씨슬","<br>밀크씨슬<br><br> #밀크씨슬 씨앗 속 살리마린 성분<br> #간 기능 향상에 도움<br> #간보호 영양제<br> #독성 물질이 간에 유입되는 것 방지<br> #독소로부터 간을 보호");
		document.put("칼슘","<br>칼슘<br><br> #골다공증 감소에 도움<br> #뼈와 치아 형성 신경에 도움<br> #근육의 기능에 도움<br> #혈액의 응고에 도움");
		document.put("마그네슘","<br>마그네슘<br><br> #뼈 속 칼슘의 결정에 필요한 효소에 도움<br> #에너지 생산 과정에 중요한 역할<br> #3대 영양소의 합성, 심신 안정에 효과<br> #혈관의 제대로된 작동에 도움");
		document.put("프로폴리스","<br>프로폴리스<br><br> #뼈 조직을 건강하게 유지하는데 도움<br> #해로운 미생물 억제<br> #강력한 항생제 성분 제공<br> #포도 상구균을 포함한 박테리아를 효과적으로 막음");
		document.put("단백질","<br>단백질<br><br> #모발과 두뇌에 효능<br> #골다공증 예방<br> #면역력 증진<br> #피부 탄력 강화");
		if(nutrious2[3]!=1)
			document.put("멀티비타민","<br>멀티비타민<br><br> #모발과 두뇌에 효능<br> #골다공증 예방<br> #면역력 증진<br> #피부 탄력 강화");
		
				
		if(nButton!=null) { //nutrious 이전 값 받아오기
			for(int i=0;i<12;i++) {
				nutrious[i]=Integer.parseInt(nButton[i]);
			}
		}
		set.put("프로바이오틱스",nutrious[0]);
		set.put("비타민C",nutrious[1]);
		if(nutrious2[1]!=1)
			set.put("비타민A",nutrious[2]);
		set.put("루테인",nutrious[3]);
		set.put("오메가3",nutrious[4]);
		if(nutrious2[2]!=1)
			set.put("비타민B",nutrious[5]);
		set.put("밀크씨슬",nutrious[6]);
		set.put("칼슘",nutrious[7]);
		set.put("마그네슘",nutrious[8]);
		set.put("프로폴리스",nutrious[9]);
		set.put("단백질",nutrious[10]);
		if(nutrious2[3]!=1)
			set.put("멀티비타민",nutrious[11]);
		
		List<String> keySetList = new ArrayList<>(set.keySet()); 
		Collections.sort(keySetList, (k1, k2) -> (set.get(k2).compareTo(set.get(k1)))); 
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> result2=new ArrayList<>();
		
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		
		ArrayList<MemberNutrition> memberNutrition=new ArrayList<>();
		
		int check=0;
		for (String key : keySetList) {
			if (set.get(key) > 0) {
				System.out.println("key : " + key + " / " + "value : " + set.get(key));
				result.add(key);
				result2.add(document.get(key));

				if (loginUser != null) {
					if (check < 4) {
						memberNutrition.add(new MemberNutrition(loginUser.getUserId(), key));
					}
					check++;
				}
			}
		}
		
		if (loginUser != null) {
			new MemberService().deleteNutrition(loginUser.getUserId());
			new MemberService().insertNutrition(memberNutrition);
		}
	
		request.setAttribute("result", result);
		request.setAttribute("result2", result2);
		request.getRequestDispatcher("views/diagnosis/DiagnosisResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
