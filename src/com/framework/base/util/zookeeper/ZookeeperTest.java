package com.framework.base.util.zookeeper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import com.sun.corba.se.spi.ior.Writeable;

public class ZookeeperTest {

	/**
	 * @param args
	 *@author lyj [May 29, 2015]
	 */

		// 根节点  
		public static final String ROOT = "/root-ktv";  
		  
		public static void main(String[] args) throws Exception {  
		    // 创建一个与服务器的连接  
//		    ZooKeeper zk = new ZooKeeper("localhost:2181,localhost:2182,localhost:2183", 30000, new Watcher() {  
//		        // 监控所有被触发的事件  
//		        public void process(WatchedEvent event) {  
//		            System.out.println("状态:" + event.getState()+":"+event.getType()+":"+event.getWrapper()+":"+event.getPath());  
//		        }  
//		    });  
//		    // 创建一个总的目录ktv，并不控制权限，这里需要用持久化节点，不然下面的节点创建容易出错  
//		    zk.create(ROOT, "root-ktv".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);  
//		  
//		    // 然后杭州开一个KTV ,       PERSISTENT_SEQUENTIAL 类型会自动加上 0000000000 自增的后缀  
//		    zk.create(ROOT+"/杭州KTV", "杭州KTV".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);  
//		  
//		    // 也可以在北京开一个,       EPHEMERAL session 过期了就会自动删除  
//		    zk.create(ROOT+"/北京KTV", "北京KTV".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);  
//		  
//		    // 同理，我可以在北京开多个，EPHEMERAL_SEQUENTIAL  session 过期自动删除，也会加数字的后缀  
//		    zk.create(ROOT+"/北京KTV-分店", "北京KTV-分店".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);  
//		  
//		    // 我们也可以 来看看 一共监视了多少家的ktv  
//		    List<String> ktvs = zk.getChildren(ROOT, true);  
//		    System.out.println(Arrays.toString(ktvs.toArray()));  
//		    for(String node : ktvs){  
//		    	System.out.println("del:"+node);  
//		        // 删除节点  
//		        zk.delete(ROOT+"/"+node,-1);  
//		    }  
//		    // 根目录得最后删除的  
//		    zk.delete(ROOT, -1);  
//		    zk.close();  
			//write();
			//read();
			//del();
		} 
		public static void write() throws Exception{
			// 创建一个与服务器的连接  
		    ZooKeeper zk = new ZooKeeper("localhost:2181,localhost:2182,localhost:2183", 30000, new Watcher() {  
		        // 监控所有被触发的事件  
		        public void process(WatchedEvent event) {  
		            System.out.println("状态:" + event.getState()+":"+event.getType()+":"+event.getWrapper()+":"+event.getPath());  
		        }  
		    }); 
		    // 创建一个总的目录ktv，并不控制权限，这里需要用持久化节点，不然下面的节点创建容易出错  
		    zk.create(ROOT, "root-ktv".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);  
		  
		    // 然后杭州开一个KTV ,       PERSISTENT_SEQUENTIAL 类型会自动加上 0000000000 自增的后缀  
		    zk.create(ROOT+"/杭州KTV", "杭州KTV".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);  
		  
		    // 也可以在北京开一个,       EPHEMERAL session 过期了就会自动删除  
		    zk.create(ROOT+"/北京KTV", "北京KTV".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);  //
		  
		    // 同理，我可以在北京开多个，EPHEMERAL_SEQUENTIAL  session 过期自动删除，也会加数字的后缀  
		    zk.create(ROOT+"/北京KTV-分店", "北京KTV-分店".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL); 
		    // 我们也可以 来看看 一共监视了多少家的ktv  
		    List<String> ktvs = zk.getChildren(ROOT, true);  
		    System.out.println(Arrays.toString(ktvs.toArray())); 
		    zk.close(); 
		}
		public static void read() throws Exception{
			// 创建一个与服务器的连接  
		    ZooKeeper zk = new ZooKeeper("localhost:2181,localhost:2182,localhost:2183", 30000, new Watcher() {  
		        // 监控所有被触发的事件  
		        public void process(WatchedEvent event) {  
		            System.out.println("状态:" + event.getState()+":"+event.getType()+":"+event.getWrapper()+":"+event.getPath());  
		        }  
		    }); 
		    // 我们也可以 来看看 一共监视了多少家的ktv  
		    List<String> ktvs = zk.getChildren(ROOT, true);  
		    System.out.println(Arrays.toString(ktvs.toArray()));
		    zk.close(); 
		}
        public static void del() throws Exception{
        	// 创建一个与服务器的连接  
		    ZooKeeper zk = new ZooKeeper("localhost:2181,localhost:2182,localhost:2183", 30000, new Watcher() {  
		        // 监控所有被触发的事件  
		        public void process(WatchedEvent event) {  
		            System.out.println("状态:" + event.getState()+":"+event.getType()+":"+event.getWrapper()+":"+event.getPath());  
		        }  
		    }); 
        	// 我们也可以 来看看 一共监视了多少家的ktv  
		    List<String> ktvs = zk.getChildren(ROOT, true);  
		    System.out.println(Arrays.toString(ktvs.toArray()));  
		    for(String node : ktvs){  
		    	System.out.println("del"+node);
		        // 删除节点  
		        zk.delete(ROOT+"/"+node,-1);  
		    }  
		    // 根目录得最后删除的  
		    zk.delete(ROOT, -1);  
		    zk.close(); 
        }

}
