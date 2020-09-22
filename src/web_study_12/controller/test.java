package web_study_12.controller;

import web_study_12.dto.Board;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Board b = new Board(2);
		System.out.println(b);
		
		//reflexing 기법이용
		Class<?> cls = Class.forName("web_study_12.dto.Board");
		Board b2 = (Board) cls.newInstance();
		System.out.println(b2);

	}

}
