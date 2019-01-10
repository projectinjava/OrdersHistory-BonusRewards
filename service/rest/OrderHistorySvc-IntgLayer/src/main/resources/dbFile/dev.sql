CREATE DEFINER=`root`@`localhost` PROCEDURE `GETOrderHistory`(IN client_Id varchar(20),
IN channel_Id varchar(20),
IN card_Number varchar(20),
OUT statuscode varchar(30),
OUT statusmessage varchar(30) )

proc_label:BEGIN
	
declare clientidcount int;
declare channelidcount int;
declare cardnumbercount int;

select count(*) into clientidcount from client_details where clientId=client_Id;
IF (clientidcount<=0)then
set statuscode="100";
set statusmessage="client ID Invalid";
leave proc_label;

elseIf clientidcount>0 then
select count(*) into channelidcount from client_details where channelId=channel_Id;

IF (channelidcount<=0)then
set statuscode="101";
set statusmessage="channel ID Invalid";
leave proc_label;

ElseIf channelidcount>0 then
select count(*) into cardnumbercount from customer_details where cardNumber=card_Number;

IF (cardnumbercount<=0)then
set statuscode="103";
set statusmessage="cardnumber Invalid";
leave proc_label;

elseif cardnumbercount>=0 then


select * from orderhistory.orderhistory_details where cardnumber=card_Number;
set statuscode=0;
set statusmessage="success";
END If;
end if;
end if;
end