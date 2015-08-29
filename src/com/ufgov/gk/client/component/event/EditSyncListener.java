package com.ufgov.gk.client.component.event;

import java.util.EventListener;

public interface EditSyncListener extends EventListener {
	
	 void sync(EditSyncEvent e);

}
