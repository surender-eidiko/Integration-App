package com.cisco.integrations.model;

import com.cisco.integrations.model.CommonBean;

public class TrelloAppBean  extends CommonBean{
	private String boardId;
	private String[] boardsAndListNotifications;
	private String[] cardsNotifications;
	private String[] checkLists;

	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String[] getBoardsAndListNotifications() {
		return boardsAndListNotifications;
	}
	public void setBoardsAndListNotifications(String[] boardsAndListNotifications) {
		this.boardsAndListNotifications = boardsAndListNotifications;
	}
	public String[] getCardsNotifications() {
		return cardsNotifications;
	}
	public void setCardsNotifications(String[] cardsNotifications) {
		this.cardsNotifications = cardsNotifications;
	}
	public String[] getCheckLists() {
		return checkLists;
	}
	public void setCheckLists(String[] checkLists) {
		this.checkLists = checkLists;
	}
	
}
