INSERT INTO screenings (
    id,
    user_id,
    profession,
    linkedin,
    activity_area,
    current_position,
    area_of_interest,
    desired_position,
    time_to_achieve_goal,
    active,
    created_at,
    updated_at,
    deleted_at
) VALUES (
             '123e4567-e89b-12d3-a456-426614174000',  -- id (UUID, gerado automaticamente)
             '987e6543-e21b-32d4-a876-426614174001',  -- user_id
             'Desenvolvedor de Software',               -- profession
             'https://www.linkedin.com/in/usuario',    -- linkedin
             'Tecnologia da Informação',                 -- activity_area
             'Desenvolvedor Sênior',                     -- current_position
             'Arquitetura de Software',                  -- area_of_interest
             'Engenheiro de Software',                   -- desired_position
             '2025-12-31',                              -- time_to_achieve_goal
             true,                                      -- active
             CURRENT_TIMESTAMP,                         -- created_at
             CURRENT_TIMESTAMP,                         -- updated_at
             NULL                                       -- deleted_at (inicialmente nulo)
         );
