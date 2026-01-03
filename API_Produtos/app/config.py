import os
from dotenv import load_dotenv

load_dotenv()

class Config():
    
    POSTGRE_DB = os.getenv("POSTGRE_DB")
    POSTGRE_PORT = os.getenv("POSTGRE_PORT")
    POSTGRE_USER = os.getenv("POSTGRE_USER")
    POSTGRE_PASS = os.getenv("POSTGRE_PASS")
    SQLALCHEMY_DATABASE_URI = F"postgresql://{POSTGRE_USER}:{POSTGRE_PASS}@localhost:{POSTGRE_PORT}/{POSTGRE_DB}"