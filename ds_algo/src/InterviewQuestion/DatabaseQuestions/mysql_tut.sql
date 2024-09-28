
select * from user where user_id = 454;


select * from user where user_id in (select user_id from user_roles where role_id = 5);



select * from (
 select * from user where user_id = 4
)




select * from (
 select * from user where user_id in (select user_id from user_roles where role_id = 5)
) as subquery

INITIATED,PENDING,INPROGRESS, SUCCESS | FAILED ,REFUND ,

PAYMENT GATEWAYS :
   PHONEPE,
   RAZORPAY,
   
   PAYTM,
   CREDIT_CARD,
   UPI,
   NET_BANKING,
   BANK_TRANSFER,
   INTERNET_BANKING,




