-- schema.sql
CREATE TABLE IF NOT EXISTS screenings (
    id UUID PRIMARY KEY,
    userId UUID,
    profession VARCHAR(255),
    linkedin VARCHAR(255),
    activityArea VARCHAR(255),
    currentPosition VARCHAR(255),
    areaOfInterest VARCHAR(255),
    desiredPosition VARCHAR(255),
    timeToAchieveGoal DATE,
    active BOOLEAN,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP,
    deletedAt TIMESTAMP
);
