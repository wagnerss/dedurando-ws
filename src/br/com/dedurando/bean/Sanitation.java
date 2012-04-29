package br.com.dedurando.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity  
@Table(name="DDR_SANITATION")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  
public class Sanitation extends Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
}
