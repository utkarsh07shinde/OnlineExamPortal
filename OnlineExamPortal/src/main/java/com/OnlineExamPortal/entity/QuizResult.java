package com.OnlineExamPortal.entity;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quiz_results")
public class QuizResult {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long quizResId;

	    @Column(name = "user_id")
	    private Long userId;

	    @Column(name = "total_obtained_marks")
	    private float totalObtainedMarks;

	    @Column(name = "attempt_datetime")
	    private String attemptDatetime;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    private Quiz quiz;



}

