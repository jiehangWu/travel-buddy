CREATE TABLE Postcode (
    code char(10),
    city char(20),
    country char(50),
    PRIMARY KEY (code)
);

create table Geolocation (
    longitude NUMERIC(7, 4),
    latitude NUMERIC(7, 4),
    streetNumber char(50),
    postcode char(10),
    primary key (latitude, longitude),
    foreign key (postcode) references  Postcode on delete no action
);

create table CovidCase(
    id serial,
    longitude NUMERIC(7, 4),
    latitude NUMERIC(7, 4),
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
    longitude NUMERIC(7, 4),
    latitude NUMERIC(7, 4),
    name char(50),
    primary key (id),
    foreign key (latitude, longitude) references Geolocation (latitude, longitude) on delete no action
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
    longitude NUMERIC(7, 4) not null,
    latitude NUMERIC(7, 4) not null,
    userId serial not null,
    primary key (id),
    foreign key (latitude, longitude) references Geolocation(latitude, longitude) on delete no action,
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

