package com.hibernate.OneToMany;
  
import javax.persistence.*;  
import java.util.List;    
  
@Entity  
@Table(name="Question")  
public class Question {    
  
@Id   
@GeneratedValue(strategy=GenerationType.SEQUENCE)  
private int id;    
private String qname;    
  
@OneToMany(cascade = CascadeType.ALL ,  fetch = FetchType.EAGER)  
@JoinColumn(name="qid")  
@OrderColumn(name="type")  
private List<Answer> answers;  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getQname() {  
    return qname;  
}  
public void setQname(String qname) {  
    this.qname = qname;  
}  
public List<Answer> getAnswers() {  
    return answers;  
}  
public void setAnswers(List<Answer> answers) {  
    this.answers = answers;  
}      
} 
