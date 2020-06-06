CREATE TABLE Postcode (
code char(10),
city char(20),
country char(50),
PRIMARY KEY (code)
);

create table Geolocation (
    longitude decimal,
    latitude decimal,
    streetNumber char(50),
    postcode char(10),
    primary key (longitude, latitude),
    foreign key (postcode) references  Postcode on delete no action
);

create type CovidCaseType as enum('suspected', 'confirmed', 'recovered', 'death');

create table CovidCase(
    id uuid,
    longitude decimal,
    latitude decimal,
    caseType CovidCaseType,
    primary key (id)
);

create table Contributor(
    id uuid,
    username varchar,
    password varchar,
    primary key (id)
);

create table PublicArea(
    id uuid,
    longitude decimal,
    latitude decimal,
    name char(50),
    primary key (id),
    foreign key (longitude, latitude) references Geolocation (longitude, latitude) on delete no action
);

create table AppUser(
    id uuid,
    username varchar,
    password varchar,
    displayName varchar,
    gender char(10),
    age integer,
    email varchar,
    acceptedRiskLevel integer,
    notificationMethod char(10),
    primary key (id),
    unique(email)
);

create table MakeComment(
    cid uuid,
    content varchar,
    upvote integer,
    downvote integer,
    longitude decimal not null,
    latitude decimal not null,
    userId uuid not null,
    primary key (cid),
    foreign key (longitude, latitude) references Geolocation(longitude, latitude) on delete no action,
    foreign key (userId) references User on delete no action
);

create table Suggestion(
    id uuid,
    content varchar,
    timestamp char(50),
    primary key (id)
);

crate table GiveSuggestion(
    userId uuid,
    suggestionId uuid,
    primary key (userId, suggesionId),
    foreign key (userId) references AppUser on delete cascade,
    foreign key (suggestionId) references Suggestion on delete no action
);

create table Producer(
    name varchar,
    phone char(20),
    email varchar,
    primary key (name)
);

create type EquipmentType as enum ('Goggles', 'Mask', 'Gloves', 'Other');

create table SafetyEquipment(
    id uuid,
    type EquipmentType,
    typeId uuid,
    producerName char(50),
    description varchar,
    primary key (id),
    foreign key (producerName) references Producer on delete no action
);

create table Goggles(
    id uuid,
    type char(20),
    primary key (id)
);

create table Mask(
    id char(50),
    medicalGrade char(20),
    primary key (id)
);

create table Gloves(
    id uuid,
    material char(20),
    primary key (id)
);

create table ProvideEquipment(
    publicAreaId uuid,
    equipment uuid,
    primary key (publicAreaId, equipmentId),
    foreign key (publicAreaId) references PublicArea on delete cascade,
    foreign key (equipmentId) references SafetyEquipment on delete no action
);

