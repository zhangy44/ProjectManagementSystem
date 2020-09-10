package com.yyz.pma.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyz.pma.dao.ProjectRepository;
import com.yyz.pma.dto.ChartData;
import com.yyz.pma.entities.Project;
@Service
public class ProjectService {
	@Autowired
	ProjectRepository proRepo;

	public Project save(Project project) {
		return proRepo.save(project);
	}

	public List<Project> getAll() {
		return proRepo.findAll();
	}

	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}
//	
//	
//	public List<TimeChartData> getTimeData(){
//		return proRepo.getTimeData();
//	}

	public Project findByProjectId(long id) {
		// TODO Auto-generated method stub
		return proRepo.findById(id);
	}

	public void delete(Project theProj) {
		// TODO Auto-generated method stub
		proRepo.delete(theProj);
	}
}
