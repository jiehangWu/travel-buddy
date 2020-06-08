insert into Postcode(code, city, country) values('V6R2H7', 'Vancouver', 'Canada');
insert into Postcode(code, city, country) values('V6T1E2', 'Vancuuver', 'Canada');
insert into Postcode(code, city, country) values('fake', 'fake city', 'fake country');

insert into CovidCase(id, longitude, latitude, casetype) values('063f7496-a7c1-11ea-bb37-0242ac130002', 1, 1, 'suspected');
insert into CovidCase(id, longitude, latitude, casetype) values('d7d0ed36-a7c7-11ea-bb37-0242ac130002', 1, 1, 'confirmed');

insert into Geolocation(longitude, latitude, streetnumber, postcode) values(49.264917, -123.203499, '4314 W 10th Ave', 'V6R2H7');
insert into Geolocation(longitude, latitude, streetnumber, postcode) values(49.275065, -123.242228, '5495 Chancellor Blvd', 'V6T1E2');
insert into Geolocation(longitude, latitude, streetnumber, postcode) values(1, 1, 'Virtual way', 'fake');

insert into makecomment(cid, ccontent, upvote, downvote, longitude, latitude, userid) values('9a3cf764-a94b-11ea-bb37-0242ac130001', 'hello', 0, 0, 1, 1, '9a3cf764-a94b-11ea-bb37-0242ac130002');
insert into makecomment(cid, ccontent, upvote, downvote, longitude, latitude, userid) values('1234567', 'hello', 0, 0, 1, 1, '7654321');

insert into appuser(id, username, password, displayname, gender, age, email, acceptedRiskLevel, notificationMethod) values('9a3cf764-a94b-11ea-bb37-0242ac130002', 'fake user', 'fake password', 'fake name', 'make', 17, 'fake email', 2, 'fake');
insert into appuer(id, username, password, displayname, gender, age, email, acceptedRiskLevel, notificationMethod) values('7654321', 'fake user', 'fake password', 'fake name', 'make', 17, 'fake email', 2, 'fake');
