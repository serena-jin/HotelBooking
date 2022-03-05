--Hotel Booking Project -------------------------------------------------------------

--DDL------------------

DROP TABLE customer cascade constraint;
DROP TABLE room cascade constraint; 
DROP TABLE booking cascade constraint; 
DROP SEQUENCE b_no_seq;


CREATE TABLE customer(
	c_id varchar2(10)
	,c_name varchar2(20)
	,c_pw varchar2(10)
);



CREATE TABLE room(
	r_id varchar2(20)
	,r_type varchar2(20)
	,r_price number(20)
	,r_bedsize varchar(20)
);



CREATE SEQUENCE b_no_seq;

CREATE TABLE booking(
	b_no NUMBER(5)
	,b_cst_id varchar2(10)
	,b_checkin DATE
	,b_checkout DATE
	,b_adults number(10)
	,b_kids number(10)
	,b_room_type varchar2(20)
);



SELECT * FROM customer;
SELECT * FROM room;
SELECT * FROM booking;



--DML------------------

-- customer insert[고객 정보 저장]
-- c_id, c_name, c_pw
insert into customer values('cst_1', '김승호', '1111');
insert into customer values('cst_2', '정샘물', '2222');
insert into customer values('cst_3', '캘리최', '3333');
insert into customer values('cst_4', '진미란', '4444');


-- room insert[룸 정보 저장]
-- r_id, r_type, r_price, r_bedsize
insert into room values('room1', 'Single Room', 100000, 'Queen');
insert into room values('room2', 'Double Room', 150000, 'King');
insert into room values('room3', 'Deluxe Room', 200000, 'LargeKing');


-- booking insert[예약 정보 저장]
-- b_no, b_cst_id, b_checkin, b_checkout, b_adults, b_kids, b_room_type
insert into booking values(b_no_seq.nextval, 'cst_1', '2022-02-01', '2022-02-05', 1, 0, 'Double Room');
insert into booking values(b_no_seq.nextval, 'cst_4', '2022-02-14', '2022/02-16', 2, 1, 'Delux Room');



commit;



SELECT * FROM room;
SELECT * FROM customer;
SELECT * FROM booking;
