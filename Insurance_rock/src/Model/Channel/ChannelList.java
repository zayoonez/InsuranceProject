package Model.Channel;

import java.util.ArrayList;

/**
 * @author ansm6
 * @version 1.0
 * @created 08-5-2022 ���� 10:34:18
 */
public interface ChannelList {

	public boolean add(Channel channel);
	public boolean delete(String channelID);
	public Channel get(String channelID);
	public ArrayList<Channel> getAll();
	public ArrayList<Channel> getName(String name);

	
//	public void update(){
//
//	}
}//end ChannelList