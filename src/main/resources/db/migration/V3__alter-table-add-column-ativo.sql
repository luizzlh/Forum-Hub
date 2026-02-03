ALTER TABLE forumhub.topicos ADD COLUMN ativo tinyint;

update forumhub.topicos set ativo = 1;