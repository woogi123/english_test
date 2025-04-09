package swEngineering.member.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import swEngineering.member.dto.MemberDTO;
import swEngineering.member.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    // 회원가입
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("MemberController.save");
        memberService.save(memberDTO);
        return "login";
    }

    // 로그인
    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, RedirectAttributes redirectAttributes){
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null){

            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "redirect:/select";
        }else {
            redirectAttributes.addFlashAttribute("loginError", "아이디를 다시 입력해주세요!");
            return "redirect:/member/login";
        }
    }
    @GetMapping("/select")
    public String mainPage() {
        return "select";
    }

    @PostMapping("/member/email-check")
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {

        String checkResult = memberService.emailCheck(memberEmail);
        return checkResult;
    }

}
