import os
from flask import Flask, request 
from .config import Config
from .database import db
from flask_cors import CORS

def create_app():
    
    app = Flask(__name__)
    app.config.from_object(Config)
    
    CORS(app, 
         resources={r"/*": {"origins": "*"}},
         allow_headers=["Content-Type", "Authorization"],
         methods=["GET", "POST", "PUT", "DELETE", "OPTIONS"],
         supports_credentials=True)
    
    db.init_app(app)
    
    from .routes.products import bp as products_bp
    
    app.register_blueprint(products_bp)
    
    with app.app_context():
        if not os.environ.get('IS_WORKER'):
            db.create_all()

    return app