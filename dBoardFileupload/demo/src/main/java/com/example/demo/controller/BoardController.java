package com.example.demo.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.service.BoardService;
import com.example.demo.util.MD5Generator;


@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // [ 요청 ] http://127.0.0.1:8080/board/xxxxxxxx
    @RequestMapping("/{step}")
    public String viewPage(@PathVariable String step){
        return "/board/"+ step;
        // WEB-INF/views/ + board + xxxxxxxx + .jsp
    }

    // 글목록검색
    // [ 요청 ] http://127.0.0.1:8080/board/getBoardList
    @RequestMapping("getBoardList")
    public void getBoardList(Model m) {
        List<BoardVO> list = boardService.getBoardList();
        System.out.println("확인1");
        m.addAttribute("boardList", list);
        // WEB-INF/views/ + board/getBoardList + .jsp
    }

    // 글 상세 보기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("getBoard")
    public void getBoard(BoardVO vo, Model m) {
        BoardVO board = boardService.getBoard(vo);
        System.out.println("확인2");
        m.addAttribute("board", board);
        // WEB-INF/views/ + board/getBoardList + .jsp
    }

     // 글 저장하기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("saveBoard")
    public String saveBoard(@RequestParam("file") MultipartFile file, BoardVO vo) {
        // int result = boardService.saveBoard(vo);
        // System.out.println("확인2 : " + result);
        // return "getBoradList";
        String originFilename = file.getOriginalFilename();
        System.out.println("originFilename: " + originFilename);

        if(originFilename != null && !originFilename.equals("")) {
            // 파일첨부가 있는 경우
            try {
                String filename = new MD5Generator(originFilename).toString();

                // 생성되는 폴더의 위치를 확인 후 추후 변경
                // -> static 폴더 밑으로 이동해야 사용자가 그 파일을 접근 가능
                String savePath = System.getProperty("user.dir") + "\\files";
                if (!new File(savePath).exists()) {
                    new File(savePath).mkdir();
                }
                String filepath = savePath + "\\" + filename;

                System.out.println("filepath:" + filepath);

                // 업로드한 파일 =>  경로에 업로딩 = 파일저장
                file.transferTo(new File(filepath));

                // DB저장
                FileVO fvo = new FileVO();
                fvo.setOriginFilename(originFilename);
                fvo.setFilename(filename);
                fvo.setFilepath(filepath);
                // 첨부된 파일이 있으므로 fvo를 넣어준다.
                boardService.saveBoard(vo, fvo);

                }catch (Exception ex) {
                        System.out.println("파일업로드 실패:" + ex.getMessage());
                }
        }else {
            // 파일첨부가 없는 경우
            boardService.saveBoard(vo, null);
        }

        return "redirect:getBoardList";
        // WEB-INF/views/ + board/getBoardList + .jsp
    }


     // 글 수정하기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("updateBoard")
    public String updateBoard(BoardVO vo) {
        int result = boardService.updateBoard(vo);
        System.out.println("확인2 : " + result);
        // return "getBoradList";
        return "redirect:getBoardList";
        // WEB-INF/views/ + board/getBoardList + .jsp
    }

    // 글 삭제하기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("deleteBoard")
    public String deleteBoard(BoardVO vo) {
        int result = boardService.deleteBoard(vo);
        System.out.println("확인2 : " + result);
        // return "getBoradList";
        return "redirect:getBoardList";
        // WEB-INF/views/ + board/getBoardList + .jsp
    }
}
