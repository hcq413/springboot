package com.hcq.spring.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcq.spring.domain.Auction;
import com.hcq.spring.domain.Auctionrecord;
import com.hcq.spring.domain.Auctionuser;
import com.hcq.spring.service.AuctionService;
import com.hcq.spring.service.AuctionrecordService;
import com.hcq.spring.utils.Myutils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
public class AuctionController {

    @Autowired
    AuctionService auctionimpl;
    @Autowired
    AuctionrecordService auction;

    public static final int PAGE_SIZE = 10;

    /**
     * 查询身份验证
     *
     * @param pageNum 一页上一页
     * @param auction 拍卖
     * @return {@link ModelAndView}
     */
    @RequestMapping("/queryAutions")
    public ModelAndView queryAutions(@RequestParam(defaultValue = "1") int pageNum,
                                     @ModelAttribute("condition") Auction auction) {
        Myutils.printlnErr("当前页数" + pageNum);
        PageHelper.startPage(pageNum, PAGE_SIZE);
        List<Auction> actions = auctionimpl.getAllActions(auction);
        PageInfo<Auction> info = new PageInfo<>(actions);
        ModelAndView andView = new ModelAndView();
        Auctionuser user = (Auctionuser) SecurityUtils.getSubject().getPrincipal();
        andView.addObject("auctionList", actions);
        andView.addObject("Page", info);
        andView.addObject("User", user);
        andView.setViewName("index");

        return andView;
    }

    /**
     * 发布拍卖
     *
     * @param auction 拍卖
     * @param pic     图片
     * @param session 会话
     * @return {@link String}
     */
    @RequestMapping(value = "/publishAuctions", method = RequestMethod.POST)
    public String publishAuctions(Auction auction, MultipartFile pic, HttpSession session) {
        try {
            if (pic.getSize() > 0) {
                String page = "D:\\duagram";
                Myutils.printlnErr(page);
                File file = new File(page, pic.getOriginalFilename());

                pic.transferTo(file);

                //设置不能为null的参数

                auction.setAuctionpic(pic.getOriginalFilename());
                auction.setAuctionpictype(pic.getContentType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        auctionimpl.addAction(auction);
        return "redirect:/queryAutions";
    }

    /**
     * 更新
     *
     * @param id ID号
     * @return {@link ModelAndView}
     */
    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("auction", auctionimpl.selectByid(id));
        mv.setViewName("updateAuction");
        return mv;
    }

    /**
     * 提交更新拍卖
     *
     * @param auction 拍卖
     * @param pic     图片
     * @param session 会话
     * @return {@link String}
     */
    @RequestMapping(value = "/submitUpdateAuction", method = RequestMethod.POST)
    public String submitUpdateAuction(Auction auction, MultipartFile pic, HttpSession session) {
        try {
            if (pic.getSize() > 0) {
                String page = session.getServletContext().getRealPath("upload");
                File oldFile = new File(page, auction.getAuctionpic());
                if (oldFile.exists()) {
                    oldFile.delete();
                }
                File file = new File(page, pic.getOriginalFilename());

                pic.transferTo(file);

                //设置不能为null的参数

                auction.setAuctionpic(pic.getOriginalFilename());
                auction.setAuctionpictype(pic.getContentType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        auctionimpl.updateAction(auction);
        return "redirect:/queryAutions";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id) {
        auction.deleteByPrimary(id);
        auctionimpl.deleteByPrimaryKey(id);
        return "redirect:/queryAutions";
    }

    @RequestMapping("/toanctionDetail/{auctionId}")
    public ModelAndView toanctionDetail(@PathVariable Integer auctionId) {
        ModelAndView and = new ModelAndView();
        and.addObject("auctionDetail", auctionimpl.anctionamdauctionrecordbyuser(auctionId));
        and.setViewName("auctionDetail");
        return and;
    }

    @RequestMapping(value = "/saveAuctionRecord", method = RequestMethod.POST)
    public String saveAuctionRecord(Auctionrecord cord, HttpSession session) throws Exception {
        cord.setAuctiontime(new Date());
        Auctionuser user = (Auctionuser) session.getAttribute("user");
        cord.setUserid(user.getUserid());
        auction.addAuctionrecord(cord);
        return "redirect:/toanctionDetail/" + cord.getAuctionid();
    }

    @RequestMapping(value = "/AuctionEndedGoods")
    public String AuctionEndedGoods(Model model) {
        System.err.println("进来了吗");
        model.addAttribute("auctionCustom", auctionimpl.findAuctionEndedGoods());
        model.addAttribute("Auction", auctionimpl.findAuctionFinishedEndGoods());
        return "Result";
    }
}
