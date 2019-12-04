package com.happyrecipek.web.admin.schedule.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.happyrecipek.web.admin.schedule.entities.ScheduleBase;
import com.happyrecipek.web.admin.schedule.entities.ScheduleEvents;
import com.happyrecipek.web.admin.schedule.repositories.ScheduleEventDetailRepository;
import com.happyrecipek.web.admin.schedule.repositories.ScheduleEventRepository;

@Controller
public class ScheduleManagementController {

	private static final Logger log = LogManager.getLogger(ScheduleManagementController.class);

	@Autowired
	private ScheduleEventRepository scheduleEventRepository;

	@Autowired
	private ScheduleEventDetailRepository scheduleEventDetailRepository;

	/**
	 * @author KYJ
	 * @since 2019-03-17
	 * @param Device
	 * @return String Schedule List Page
	 */
	@RequestMapping("/admin/schedule/scheduleManage")
	public String scheduleListPage(Device device, Model model) {
		String returnPage = "";

		if (device.isMobile()) {
			returnPage = "web/pc/admin/schedule/manage";
		} else if (device.isTablet()) {
			returnPage = "web/pc/admin/schedule/manage";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/schedule/manage";
		}

		return returnPage;
	}

	/**
	 * @author KYJ
	 * @since 2019-03-17
	 * @param Device
	 * @return String Schedule List Page
	 */
	@RequestMapping("/admin/schedule/addEventProc")
	public @ResponseBody int scheduleAddEventProc(@ModelAttribute("scheduleBase") ScheduleBase scheduleBase) {
		ScheduleBase newBase = new ScheduleBase();
		
		for(int i = 0; i <scheduleBase.getEvents().size(); i++) {
			scheduleBase.getEvents().get(i).setScheduleEventConfirmYn("N");
		}
		
		if (scheduleBase.getScheduleSeq() > 0) {
			scheduleEventRepository.delete(scheduleBase);
			newBase = scheduleEventRepository.save(scheduleBase);
		} else {
			newBase = scheduleEventRepository.save(scheduleBase);
		}
		int resultCount = newBase.getEvents().size(); 
		
		return resultCount;
	}

	/**
	 * @author KYJ
	 * @since 2019-08-09
	 * @param Device
	 * @return String Schedule List Page
	 */
	@RequestMapping("/admin/schedule/scheduleList")
	public ModelAndView scheduleList(@RequestBody String selectDate) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<ScheduleBase> getListOfMonth = new ArrayList<ScheduleBase>();
		getListOfMonth = scheduleEventRepository.findByscheduleDateContaining(selectDate);

		String year = "";
		String month = "";
		String day = "";

		Map<String, Object> getData = new HashMap<String, Object>();
		Map<String, Object> getYear = new HashMap<String, Object>();
		Map<String, Object> getMonth = new HashMap<>();

		List<Map<String, Object>> arrayYears = new ArrayList<>();
		List<Map<String, Object>> arrayMonths = new ArrayList<>();
		List<Map<String, Object>> arrayDays = new ArrayList<>();
		List<Map<String, Object>> arrayEvents = null;

		for (ScheduleBase base : getListOfMonth) {
			arrayEvents = new ArrayList<>();

			year = base.getScheduleDate().substring(0, 4);
			month = base.getScheduleDate().substring(5, 7);
			day = base.getScheduleDate().substring(8, 10);

			Map<String, Object> createDay = new HashMap<>();
			createDay.put("int", day);
			createDay.put("seq", base.getScheduleSeq());

			for (ScheduleEvents event : base.getEvents()) {
				Map<String, Object> createEvent = new HashMap<>();
				createEvent.put("startTime", event.getScheduleEventStartTime());
				createEvent.put("endTime", event.getScheduleEventEndTime());
				createEvent.put("mTime", "");
				createEvent.put("text", event.getScheduleEventContent());
				createEvent.put("done", event.getScheduleEventConfirmYn());
				createEvent.put("seq", event.getScheduleEventSeq());
				arrayEvents.add(createEvent);
			}

			createDay.put("events", arrayEvents);

			arrayDays.add(createDay);

			getYear.put("int", year);
			getMonth.put("int", month);
		}
		arrayMonths.add(getMonth);

		getMonth.put("days", arrayDays);
		getYear.put("months", arrayMonths);
		arrayYears.add(getYear);

		getData.put("years", arrayYears);

		mv.addObject("data", getData);
		return mv;
	}

	/**
	 * @author KYJ
	 * @since 2019-08-09
	 * @param Device
	 * @return String Schedule List Page
	 */
	@RequestMapping("/admin/schedule/getEvent")
	public ModelAndView getEvent(@RequestBody String eventSeq) {
		ModelAndView mv = new ModelAndView("jsonView");
		int seq = Integer.parseInt(eventSeq);
		ScheduleBase getEvent = new ScheduleBase();

		getEvent = scheduleEventRepository.findById(seq);

		mv.addObject("event", getEvent);

		return mv;
	}
	
	/**
	 * @author KYJ
	 * @since 2019-08-09
	 * @param Device
	 * @return String Schedule List Page
	 */
	@RequestMapping("/admin/schedule/updateEventYn")
	public ModelAndView updateEventYn(@ModelAttribute("scheduleEvent") ScheduleEvents scheduleEvent) {
		ModelAndView mv = new ModelAndView("jsonView");
		
		ScheduleEvents getEvent = scheduleEventDetailRepository.findByScheduleEventSeq(scheduleEvent.getScheduleEventSeq());
		getEvent.setScheduleEventConfirmYn(scheduleEvent.getScheduleEventConfirmYn());
		ScheduleEvents saveEvent = scheduleEventDetailRepository.save(getEvent);
		if(scheduleEvent.getScheduleEventConfirmYn().equals(saveEvent.getScheduleEventConfirmYn())) {
			mv.addObject("result", "SUCCESS");
		}else {
			mv.addObject("result", "FAILED");
		}
		return mv;
	}
}
