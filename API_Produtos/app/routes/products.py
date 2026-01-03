from flask import Blueprint, jsonify, request, current_app
from ..services.product_service import get_all_products
from ..config import Config
from ..database import db

bp = Blueprint('products', __name__, url_prefix='/products')

# Handler para OPTIONS (preflight CORS)
@bp.route('/', methods=['OPTIONS'])
@bp.route('/<int:product_id>', methods=['OPTIONS'])
def handle_options(product_id=None):
    return '', 204

@bp.get("/")
def list_products():
    products = get_all_products()
    return jsonify([
        {"id": p.id, "name": p.name, "price": float(p.price)}
        for p in products
    ])

@bp.post("/")
def create_product():
    
    # Confirmar mínimo (vulgo name e price)
    
    return ""