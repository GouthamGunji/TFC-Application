package com.tfc.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderlineSchedule {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
//private Date date_id;
   @ManyToOne(cascade = CascadeType.ALL)
   private OrderLineItem order_line_id;
   private String warehouse_Location;
   private Integer warehouse_id;
}
