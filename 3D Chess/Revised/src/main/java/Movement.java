public class Movement extends MoveTemplate { //FIXME : TODO COMBINE WITH MoveTemplate

    public Movement(Position position) {
        super(position);
    }

    public void Movement (PieceTYPE type, Piece piece, Position position) { //TODO
        move(piece, position, type);
        /*switch (type) {
            case PAWN : { Pawn pawn = new Pawn(piece.getPosition()); new pawnMovement(pawn,position); break; } //TODO
            case KNIGHT : { Knight knight = new Knight(piece.getPosition()); new knightMovement(knight,position); break; } //TODO
            case ROOK : { rookMovement(); break; } //TODO
            case BISHOP : { bishopMovement(); break; } //TODO
            case QUEEN : { queenMovement(); break; } //TODO
            case KING : { kingMovement(); break; } //TODO
            case PIECE: { pieceMovement(); new MovementRulesException("Unknown Piece: " + type); break; } //TODO
        }*/

    }

    /*public class pawnMovement { //TODO

        public pawnMovement (Pawn pawn, Position position) { //TODO
            move(pawn, position, PieceTYPE.PAWN); //TODO FIXME
        }

    }

    public class knightMovement { //TODO

        public knightMovement (Knight knight, Position position) { //TODO
            Movement(PieceTYPE.KNIGHT, knight, position); //TODO FIXME
        }

    }
    public void rookMovement () { *//** * **//* }
    public void bishopMovement () { *//** * **//* }
    public void queenMovement () { *//** * **//* }
    public void kingMovement () { *//** * **//* }
    public void pieceMovement () { }
*/

}
