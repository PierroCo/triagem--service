INSERT INTO screenings (
    id, 
    userId, 
    profession, 
    linkedin, 
    activityArea, 
    currentPosition, 
    areaOfInterest, 
    desiredPosition, 
    timeToAchieveGoal, 
    active, 
    createdAt, 
    updatedAt, 
    deletedAt
) VALUES (
    '3f4e234a-8c39-4a2d-bcbb-9981f1234567',  -- ID gerado
    'c2a234e3-12b6-4d2a-b89c-2f5e1d334567',  -- userId (substitua por um UUID válido)
    'Software Engineer',                    -- profession
    'https://www.linkedin.com/in/usuario',  -- linkedin
    'IT',                                   -- activityArea
    'Developer',                            -- currentPosition
    'Machine Learning',                     -- areaOfInterest
    'ML Engineer',                          -- desiredPosition
    '2025-12-31',                           -- timeToAchieveGoal (formato: YYYY-MM-DD)
    true,                                   -- active
    '2024-11-02T15:45:00Z',                 -- createdAt (substitua pelo timestamp desejado)
    '2024-11-02T15:45:00Z',                 -- updatedAt (substitua pelo timestamp desejado)
    NULL                                    -- deletedAt
);
