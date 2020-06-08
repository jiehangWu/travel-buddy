insert into Postcode(code, city, country) values('V6R2H7', 'Vancouver', 'Canada');
insert into Postcode(code, city, country) values('V6T1E2', 'Vancuuver', 'Canada');
insert into Postcode(code, city, country) values('fake', 'fake city', 'fake country');

insert into CovidCase(id, longitude, latitude, casetype) values('1', 1, 1, 'suspected');
insert into CovidCase(id, longitude, latitude, casetype) values('2', 1, 1, 'confirmed');

insert into Geolocation(longitude, latitude, streetnumber, postcode) values(49.264917, -123.203499, '4314 W 10th Ave', 'V6R2H7');
insert into Geolocation(longitude, latitude, streetnumber, postcode) values(49.275065, -123.242228, '5495 Chancellor Blvd', 'V6T1E2');
insert into Geolocation(longitude, latitude, streetnumber, postcode) values(1, 1, 'Virtual way', 'fake');

insert into appuser(id, username, password, displayname, gender, age, email, acceptedRiskLevel, notificationMethod) values(4, 'fake user', 'fake password', 'fake name', 'make', 17, 'fake email', 2, 'fake');
insert into appuser(id, username, password, displayname, gender, age, email, acceptedRiskLevel, notificationMethod) values(7654321, 'fake user', 'fake password', 'fake name', 'make', 17, 'fake email', 2, 'fake');

insert into makecomment(id, ccontent, upvote, downvote, longitude, latitude, userid) values(3, 'hello', 0, 0, 1, 1, 4);
insert into makecomment(id, ccontent, upvote, downvote, longitude, latitude, userid) values('1234567', 'hello', 0, 0, 1, 1, 7654321);


