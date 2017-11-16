package com.ifisolution.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.data.cassandra.repository.MapId;

public class CustomMapId implements MapId{

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable put(String key, Serializable value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Serializable> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Serializable> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<String, Serializable>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapId with(String name, Serializable value) {
		// TODO Auto-generated method stub
		return null;
	}

}
