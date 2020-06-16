CREATE TABLE Postcode (
code char(10),
city char(20),
country char(50),
PRIMARY KEY (code)
);

create table Geolocation (
    longitude varchar,
    latitude varchar,
    streetNumber char(50),
    postcode char(10),
    primary key (longitude, latitude),
    foreign key (postcode) references  Postcode on delete no action
);

create table CovidCase(
    id serial,
    longitude varchar,
    latitude varchar,
    caseType char(10),
    primary key (id)
);

create table Contributor(
    id serial,
    username varchar,
    password varchar,
    primary key (id)
);

create table PublicArea(
    id serial,
    longitude varchar,
    latitude varchar,
    name char(50),
    primary key (id),
    foreign key (longitude, latitude) references Geolocation (longitude, latitude) on delete no action
);

create table AppUser(
    id serial,
    username varchar,
    password varchar,
    displayName varchar,
    gender char(10),
    age serial,
    email varchar,
    acceptedRiskLevel serial,
    notificationMethod char(10),
    primary key (id),
    unique(email)
);

create table MakeComment(
    id serial,
    ccontent varchar,
    upvote serial,
    downvote serial,
    longitude varchar not null,
    latitude varchar not null,
    userId serial not null,
    primary key (id),
    foreign key (longitude, latitude) references Geolocation(longitude, latitude) on delete no action,
    foreign key (userId) references AppUser on delete no action
);

create table Suggestion(
    id serial,
    content varchar,
    timestamp char(50),
    primary key (id)
);

create table GiveSuggestion(
    userId serial,
    suggestionId serial,
    primary key (userId, suggestionId),
    foreign key (userId) references AppUser on delete cascade,
    foreign key (suggestionId) references Suggestion on delete no action
);

create table Producer(
    name varchar,
    phone char(20),
    email varchar,
    primary key (name)
);

create table SafetyEquipment(
    id serial,
    type char(20),
    typeId serial,
    producerName char(50),
    description varchar,
    primary key (id),
    foreign key (producerName) references Producer on delete no action
);

create table Goggles(
    id serial,
    type char(20),
    primary key (id)
);

create table Mask(
    id serial,
    medicalGrade char(20),
    primary key (id)
);

create table Gloves(
    id serial,
    material char(20),
    primary key (id)
);

create table ProvideEquipment(
    publicAreaId serial,
    equipmentId serial,
    primary key (publicAreaId, equipmentId),
    foreign key (publicAreaId) references PublicArea on delete cascade,
    foreign key (equipmentId) references SafetyEquipment on delete no action
);

