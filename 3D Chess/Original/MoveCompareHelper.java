public abstract class MoveCompareHelper extends ThreeDimensionalExceptions {
    public MoveCompareHelper() { }

    public boolean pawnFirstMove(Position oldPosition){
        if (oldPosition.getZCoordinate() == 1) { return true; }
        return false;
    }

    public void exceptions(byte exception){
        switch (exception) {
            case -5:    {
                new MovementExceedsMinimum("-5"); //TODO
                break;
            }
            case -10:   {
                new MovementExceedsMaximum("-10"); //TODO
                break;
            }
            default:    {
                break;
            }
        }
    }

}
