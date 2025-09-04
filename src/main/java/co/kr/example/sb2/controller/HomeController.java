package co.kr.example.sb2.controller;

import co.kr.example.sb2.entity.Sido;
import co.kr.example.sb2.repository.SidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

     @Autowired
     private SidoRepository sidoRepository;
    
    @Value("${DB_FOO:NOT_FOUND}")
    private String dbFooValue;
    
    @Value("${DB_PASSWORD:NOT_FOUND}")
    private String dbPasswordValue;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Spring Boot 프로젝트");
        model.addAttribute("message", "환영합니다! Spring Boot + Thymeleaf + Tailwind CSS + Alpine.js + HTMX 프로젝트입니다.");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "소개 - about");
        model.addAttribute("message", "이 프로젝트는 현대적인 웹 개발 스택으로 구성되었습니다.");
        return "about";
    }

    @GetMapping("/sido")
    public String sido(Model model, @RequestParam(defaultValue = "1") int page) {

        int pageSize = 10;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Sido> sidoPage = sidoRepository.findAllOrderBySeqDesc(pageable);
        
        model.addAttribute("title", "시도 관리");
        model.addAttribute("sidoList", sidoPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sidoPage.getTotalPages());
        model.addAttribute("totalElements", sidoPage.getTotalElements());
        model.addAttribute("hasNext", sidoPage.hasNext());
        model.addAttribute("hasPrevious", sidoPage.hasPrevious());
        
        // 페이지네이션 계산 (5개 단위)
        int startPage = Math.max(1, ((page - 1) / 5) * 5 + 1);
        int endPage = Math.min(sidoPage.getTotalPages(), startPage + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        
        return "sido";
    }
    
    @GetMapping("/env-test")
    @ResponseBody
    public String envTest() {
        return String.format(
            "환경변수 테스트 결과:<br>" +
            "DB_FOO: %s<br>" +
            "DB_PASSWORD: %s<br>" +
            "spring-dotenv 라이브러리 작동 상태: %s",
            dbFooValue,
            dbPasswordValue.equals("NOT_FOUND") ? "NOT_FOUND" : "[HIDDEN]",
            (!dbFooValue.equals("NOT_FOUND") || !dbPasswordValue.equals("NOT_FOUND")) ? "정상 작동" : "작동 안함"
        );
    }
}