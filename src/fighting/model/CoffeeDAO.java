package fighting.model;

import java.util.ArrayList;

public class CoffeeDAO {
	private ArrayList<model.CoffeeDTO> datas;
	private int NUM;
	public CoffeeDAO() {
		this.datas=new ArrayList<>();
		this.NUM=1010;
	}

	public ArrayList<model.CoffeeDTO> selectAll(model.CoffeeDTO dto) {
		ArrayList<model.CoffeeDTO> datas=new ArrayList<>();
		for(int i=0;i<this.datas.size();i++) {
			model.CoffeeDTO data=new model.CoffeeDTO();
			data.setNum(this.datas.get(i).getNum());
			data.setName(this.datas.get(i).getName());
			data.setDetail(this.datas.get(i).getDetail());
			datas.add(data);
		}
		return datas;
	}
	private model.CoffeeDTO selectOne(model.CoffeeDTO dto) {
		return null;
	}

	public boolean insert(model.CoffeeDTO dto) {
		try {
			model.CoffeeDTO data=new model.CoffeeDTO();
			data.setNum(this.NUM++);
			data.setName(dto.getName());
			data.setDetail(dto.getDetail());
			this.datas.add(data);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	public boolean update(model.CoffeeDTO dto) {
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==dto.getNum()) {
				this.datas.get(i).setDetail(dto.getDetail());
				return true;
			}
		}
		return false;
	}
	private boolean delete(model.CoffeeDTO dto) {
		return false;
	}
}
