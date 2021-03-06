package se.kth.sda.othello.imp;

import java.util.List;
import java.util.Vector;

import se.kth.sda.othello.Othello;
import se.kth.sda.othello.board.Board;
import se.kth.sda.othello.board.Node;
import se.kth.sda.othello.player.Player;

public class OthelloImp implements Othello {
    private final Player playerOne;
    private final Player playerTwo;
    private final BoardImp board;
    private Player currentPlayer;
    List<Node> nodeRes ;

    public OthelloImp(Player one, Player two) {
        this.playerOne = one;
        this.playerTwo = two;
        this.board = new BoardImp();
        nodeRes = new Vector<Node>();
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void setNode(Node node) {
        board.setNode(node);
    }

    @Override
    public List<Node> getNodesToSwap(String playerId, String nodeId) {

        Node nodes[][] = getBoard().getBoardNodes();
        Node node = new NodeImp(nodeId, playerId);
        List<Node> res = new Vector<Node>();
        //res.add(node);
        boolean foundPlayer = false;



        if(nodes[node.getXCoordinate()][node.getYCoordinate()].isMarked()) {
            // It is going to be used to collect Nodes to flip
            // for every direction seperatly.
            // Once they are transferd in res, dirRes is cleared
            // for the next direction.
            List<Node> dirRes = new Vector<Node>();

            //check NORTH

            int k = node.getXCoordinate();
            int l = node.getYCoordinate();

            if (l > 1) {
                l--;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    l--;

                    while (l >= 0) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            l--;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }
                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            //check SOUTH

            k = node.getXCoordinate();
            l = node.getYCoordinate();

            if (l < 6) {
                l++;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    l++;

                    while (l < 8) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            l++;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }
                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            //check EAST

            k = node.getXCoordinate();
            l = node.getYCoordinate();

            if (k < 6) {
                k++;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    k++;

                    while (k < 8) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            k++;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }
                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            //check WEST

            k = node.getXCoordinate();
            l = node.getYCoordinate();

            if (k > 1) {
                k--;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    k--;

                    while (k >= 0) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            k--;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }
                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            //check NORTHWEST

            k = node.getXCoordinate();
            l = node.getYCoordinate();

            if (k > 1 && l > 1) {
                k--;
                l--;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    k--;
                    l--;

                    while (k >= 0 && l >= 0) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            k--;
                            l--;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }
                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            //check SOUTHEAST

            k = node.getXCoordinate();
            l = node.getYCoordinate();

            if (k < 6 && l < 6) {
                k++;
                l++;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    k++;
                    l++;

                    while (k < 8 && l < 8) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            k++;
                            l++;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }
                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            //check NORTHEAST

            k = node.getXCoordinate();
            l = node.getYCoordinate();

            if (k < 6 && l > 1) {
                k++;
                l--;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    k++;
                    l--;

                    while (k < 8 && l >= 0) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            k++;
                            l--;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }
                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            //check SOUTHWEST

            k = node.getXCoordinate();
            l = node.getYCoordinate();

            if (k > 1 && l < 6) {
                k--;
                l++;
                if (nodes[k][l].isMarked() &&
                        !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                    dirRes.add(nodes[k][l]);

                    k--;
                    l++;

                    while (k >= 0 && l < 8) {
                        if (nodes[k][l].isMarked() &&
                                !nodes[k][l].getOccupantPlayerId().equals(playerId)) {
                            dirRes.add(nodes[k][l]);

                            k--;
                            l++;

                        } else if (!nodes[k][l].isMarked()) {
                            dirRes.clear();
                            break;
                        } else {
                            foundPlayer = true;
                            break;
                        }

                    }
                }

                if (foundPlayer && dirRes.size() > 0) {
                    for (Node node1 : dirRes) {
                        res.add(node1);
                    }
                }
                dirRes.clear();
                foundPlayer = false;
            }

            if (res.size() > 0) {
                res.add(node);
                return res;
            } else {
                return res;
            }
        }
        return res;

    }

    @Override
    public List<Node> getPossibleMoves() {
        Node nodes[][] = getBoard().getBoardNodes();
        List<Node> res = new Vector<Node>();

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {

                //check NORTH
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        nodes[i][j].getYCoordinate() > 1) {
                    int k = j-1;

                    if(nodes[i][k].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[i][k].getOccupantPlayerId())) {
                        k--;
                        while(k >= 0) {
                            if (nodes[i][k].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[i][k].getOccupantPlayerId())) {
                                k--;
                            }
                            else if(!nodes[i][k].isMarked()) {
                                res.add(nodes[i][k]);
                                break;
                            }
                            else break;

                        }
                    }

                }

                //check SOUTH
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        nodes[i][j].getYCoordinate() < 6) {
                    int k = j+1;
                    if(nodes[i][k].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[i][k].getOccupantPlayerId())) {
                        k++;
                        while(k < 8) {
                            if (nodes[i][k].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[i][k].getOccupantPlayerId())) {
                                k++;
                            }
                            else if(!nodes[i][k].isMarked()) {
                                res.add(nodes[i][k]);
                                break;
                            }
                            else break;

                        }
                    }

                }

                //check EAST
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        nodes[i][j].getXCoordinate() < 6) {
                    int k = i+1;
                    if(nodes[k][j].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[k][j].getOccupantPlayerId())) {
                        k++;
                        while(k < 8) {
                            if (nodes[k][j].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[k][j].getOccupantPlayerId())) {
                                k++;
                            }
                            else if(!nodes[k][j].isMarked()) {
                                res.add(nodes[k][j]);
                                break;
                            }
                            else break;

                        }
                    }

                }

                //check WEST
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        nodes[i][j].getXCoordinate() > 1) {
                    int k = i-1;
                    if(nodes[k][j].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[k][j].getOccupantPlayerId())) {
                        k--;
                        while(k >= 0) {
                            if (nodes[k][j].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[k][j].getOccupantPlayerId())) {
                                k--;
                            }
                            else if(!nodes[k][j].isMarked()) {
                                res.add(nodes[k][j]);
                                break;
                            }
                            else break;

                        }
                    }
                }

                //check NORTHWEST
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        (nodes[i][j].getXCoordinate() > 1 && nodes[i][j].getYCoordinate() > 1)) {
                    int k = i-1;
                    int l = j-1;
                    if(nodes[k][l].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                        k--;
                        l--;
                        while(k >= 0 && l >= 0) {
                            if (nodes[k][l].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                                k--;
                                l--;
                            }
                            else if(!nodes[k][l].isMarked()) {
                                res.add(nodes[k][l]);
                                break;
                            }
                            else break;

                        }
                    }

                }

                //check SOUTHEAST
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        (nodes[i][j].getXCoordinate() < 6 && nodes[i][j].getYCoordinate() < 6)) {
                    int k = i+1;
                    int l = j+1;
                    if(nodes[k][l].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                        k++;
                        l++;
                        while(k < 8 && l < 8) {
                            if (nodes[k][l].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                                k++;
                                l++;
                            }
                            else if(!nodes[k][l].isMarked()) {
                                res.add(nodes[k][l]);
                                break;
                            }
                            else break;

                        }
                    }
                }

                //check NORTHEAST
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        (nodes[i][j].getXCoordinate() < 6 && nodes[i][j].getYCoordinate() > 1)) {
                    int k = i+1;
                    int l = j-1;
                    if(nodes[k][l].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                        k++;
                        l--;
                        while(k < 8 && l >= 0) {
                            if (nodes[k][l].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                                k++;
                                l--;
                            }
                            else if(!nodes[k][l].isMarked()) {
                                res.add(nodes[k][l]);
                                break;
                            }
                            else break;

                        }
                    }
                }

                //check SOUTHWEST
                if(getPlayerInTurn().getId().equals(nodes[i][j].getOccupantPlayerId()) &&
                        (nodes[i][j].getXCoordinate() > 1 && nodes[i][j].getYCoordinate() < 6)) {
                    int k = i-1;
                    int l = j+1;
                    if(nodes[k][l].isMarked() &&
                            !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                        k--;
                        l++;
                        while(k >= 0 && l < 8) {
                            if (nodes[k][l].isMarked() &&
                                    !getPlayerInTurn().getId().equals(nodes[k][l].getOccupantPlayerId())) {
                                k--;
                                l++;
                            }
                            else if(!nodes[k][l].isMarked()) {
                                res.add(nodes[k][l]);
                                break;
                            }
                            else break;

                        }
                    }
                }
            }
        }
        return res;

    }

    @Override
    public Player getPlayerInTurn() {
        return this.currentPlayer;
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> res = new Vector<Player>();
        res.add(playerOne);
        res.add(playerTwo);
        return res;
    }

    @Override
    public boolean hasValidMove(String playerId) {
        if (playerId.equals(getPlayerInTurn().getId())) {
            if (getPossibleMoves().size() > 0) {
                return true;
            }
            else
                return false;
        }

        else
            return false;
    }

    @Override
    public boolean isActive() {

        if (hasValidMove(getPlayerInTurn().getId())) {
            return true;
        }
        else {
            swapPlayer();
            if (hasValidMove(getPlayerInTurn().getId())) {
                swapPlayer();
                return true;
            }
            else
                return false;
        }
    }

    @Override
    public boolean isMoveValid(String playerId, String nodeId) {

        List<Node> possibleMoves = getPossibleMoves();
        boolean isValid = false;

        if (hasValidMove(playerId)) {
            for (Node node : possibleMoves) {
                if (node.getId().equals(nodeId)) {
                    isValid = true;
                    break;
                }
            }
        }

        return isValid;
    }

    @Override
    public void swapPlayer() {
        if (currentPlayer == playerOne)
            currentPlayer = playerTwo;
        else
            currentPlayer = playerOne;
    }

    //start: modified method by Aleksandar 12.07
    @Override
    public List<Node> move() {
        if (currentPlayer.getType() != Player.Type.COMPUTER)
            throw new IllegalStateException("Current player is not a computer");

        String nodeID = getPlayerInTurn().pickMove(getPossibleMoves());

        Node newNode = new NodeImp(nodeID, currentPlayer.getId());
        board.setNode(newNode);
        nodeRes.add(newNode);

        List <Node> list = getNodesToSwap(getPlayerInTurn().getId(), nodeID);
        for (Node node : list) {
            node.setPlayerId(getPlayerInTurn().getId());
        }
        nodeRes = board.getNodes(); // update the list of nodes on the board with the swapped nodes

        swapPlayer();

        return nodeRes;
    }

    @Override
    public List<Node> move(String playerId, String nodeId) throws IllegalStateException {
        if (currentPlayer.getType() != Player.Type.HUMAN)
            throw new IllegalStateException("Current player is not a human");
        if (! isMoveValid(playerId, nodeId))
            throw new IllegalStateException("Invalid move");
        if (playerId != currentPlayer.getId())
            throw new IllegalStateException("Invalid player ID");

        Node newNode = new NodeImp(nodeId, playerId);
        board.setNode(newNode);
        nodeRes.add(newNode);

        // Swap the nodes
        List <Node> list = getNodesToSwap(playerId, newNode.getId());
        for (Node node : list) {
            node.setPlayerId(playerId);
        }
        nodeRes = board.getNodes(); // update the list of nodes on the board with the swapped nodes

        swapPlayer();

        return nodeRes;
    }

    @Override
    public void moveInitialNodes() {
        board.setNode(new NodeImp("3,3", playerOne.getId()));
        board.setNode(new NodeImp("3,4", playerTwo.getId()));
        board.setNode(new NodeImp("4,3", playerTwo.getId()));
        board.setNode(new NodeImp("4,4", playerOne.getId()));
        nodeRes = board.getNodes();
    }

    @Override
    public void start() {
        currentPlayer = playerOne;
    }

    @Override
    public void start(String playerId) {
        currentPlayer = playerOne;
    }

    @Override
    public int getPlayerScore(String playerId){
        int score =0;

        for(Node node: nodeRes){
            if(playerId.equals(node.getOccupantPlayerId())){

                score++;
            }
        }
        return score;
    }

    @Override
    public String getGameEndMessage() {
        int playerOneScore = getPlayerScore(playerOne.getId());
        int playerTwoScore = getPlayerScore(playerTwo.getId());
        String toDisplay = null;
        if (playerOneScore > playerTwoScore) {
            toDisplay = "White wins!\n"+ "The score is: \n"+ "White: " + playerOneScore + "\n" + "Black: " + playerTwoScore;
        }
        else if (playerTwoScore > playerOneScore) {
            toDisplay = "Black wins!\n "+ "The score is: \n"+ "White: " + playerOneScore + "\n" + "Black: " + playerTwoScore;
        }
        else {
            toDisplay = "Its a draw! "+ "The score is: \n"+ "White: " + playerOneScore + "\n" + "Black: " + playerTwoScore;
        }

        return toDisplay;
    }
}
