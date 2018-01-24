package com.csquare.ref.model;

public interface NamedQueryConstants {

    String getAllRefGread = "SELECT grade FROM RefGrades grade ORDER BY grade.sortorder" ;
    
    String getAllRefCity  = "SELECT city FROM RefCity city ORDER BY pk.sortorder";
    
    String getAllRefLocation = "SELECT location FROM RefLocation location";
    
    String getAllRefSubject = "SELECT subject FROM RefSubject subject ORDER BY subject.sortorder";
    
    String getAllRefSyllabus = "SELECT syllabus FROM RefSyllabus syllabus ORDER BY syllabus_name.sortorder";

}
