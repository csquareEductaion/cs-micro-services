package com.csquare.ref.model;

public interface NamedQueryConstants {

    String getAllRefGread = "SELECT grade FROM RefGrades grade ORDER BY grade.sortorder" ;
    
    String getAllRefCity  = "SELECT city FROM RefCity city";
    
    String getAllRefLocation = "SELECT location FROM RefLocation location";
    
    String getAllRefSubject = "SELECT subject FROM RefSubject subject";
    
    String getAllRefSyllabus = "SELECT syllabus FROM RefSyllabus syllabus ";

}
