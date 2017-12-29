package cn.et.lesson01.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.et.lesson01.service.ClassService;
import cn.et.lesson01.utils.PageTools;

@Controller
public class ClassController {
	@Autowired
	ClassService service;
	@RequestMapping(value="/queryClass",method=RequestMethod.GET)
	public String queryClass(String dname,Integer curPage,Model model){
		if(curPage==null){
			curPage=1;
		}
		PageTools classList = service.queryContent(dname,curPage);
		model.addAttribute("classList", classList);
		model.addAttribute("fname", dname);
		return "/detail/foodList.jsp";
	}
	
	@RequestMapping(value="/queryid/{foodId}",method=RequestMethod.GET)
	public String queryClassBd(@PathVariable String foodId,Model model){
		model.addAttribute("Myfood", service.findid(foodId));
		return "/detail/foodlist.ftl";
	}
	
	@RequestMapping(value="/update/{foodId}",method=RequestMethod.POST)
	public String updateFood(@PathVariable String foodId,String foodName,String money,MultipartFile imageUrl, Model model) throws IllegalStateException, IOException{
		String filepath = imageUrl.getOriginalFilename();
		String absPath="C:\\Users\\Administrator\\Workspaces\\MyEclipse 8.5\\.metadata\\.me_tcat\\webapps\\st\\image";
		imageUrl.transferTo(new File(absPath+"\\"+filepath));
		service.updateClass(foodId, foodName, money,filepath);
		return queryClass(null,1,model);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveFood(String foodName,String money,MultipartFile myImage, Model model) throws IllegalStateException, IOException{
		String filepath = myImage.getOriginalFilename();
		String absPath="C:\\Users\\Administrator\\Workspaces\\MyEclipse 8.5\\.metadata\\.me_tcat\\webapps\\st\\image";
		myImage.transferTo(new File(absPath+"\\"+filepath));
		service.saveClass(foodName, money, filepath);
		return queryClass(null,1,model);
	}
	
	@RequestMapping(value="/delete/{fid}",method=RequestMethod.GET)
	public String deleteClassBd(@PathVariable String fid,Model model){
		service.deleteClass(fid);
		return queryClass(null,1,model);
	}
	
	@RequestMapping(value="/down",method=RequestMethod.GET)
	public ResponseEntity<byte[]> downFood(String imagepath) throws IllegalStateException, IOException{
		String absPath = "C:\\Users\\Administrator\\Workspaces\\MyEclipse 8.5\\.metadata\\.me_tcat\\webapps\\st\\image"
				+ imagepath;
		String fileName = imagepath;
		// 需要下载的目标文件
		File file = new File(absPath);
		// 设置响应头
		HttpHeaders hh = new HttpHeaders();
		// 设置下载的文件的名称
		hh.setContentDispositionFormData("attachment", URLEncoder.encode(
				fileName, "UTF-8"));
		// 读取目标文件为二进制数组
		byte[] fileByte = FileCopyUtils.copyToByteArray(file);
		// 构建ResponseEntity对象
		ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte, hh,HttpStatus.CREATED);
		return re;
	}
}
