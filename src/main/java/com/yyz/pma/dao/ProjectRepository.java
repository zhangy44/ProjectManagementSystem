package com.yyz.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.yyz.pma.dto.ChartData;
import com.yyz.pma.entities.Project;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
	@Override
	public List<Project> findAll();

	@Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) AS value " + "FROM project " + "GROUP BY stage")
	public List<ChartData> getProjectStatus();
	
	
	public Project findById(long id);
	
	public void delete(Project pro);

}
