package fighting.model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<model.MemberDTO> datas;
	public MemberDAO() {
		this.datas=new ArrayList<>();
	}

	private ArrayList<model.MemberDTO> selectAll(model.MemberDTO dto) {
		return null;
	}
	public model.MemberDTO selectOne(model.MemberDTO dto) {
		model.MemberDTO data=null;
		if(dto.getCondition().equals("LOGIN")) {
			for(int i=0;i<this.datas.size();i++) {
				if(dto.getMid().equals(this.datas.get(i).getMid()) && dto.getMpw().equals(this.datas.get(i).getMpw())) { // mid,mpw 둘다 같다면
					data=new model.MemberDTO();
					data.setMid(dto.getMid());
					data.setMpw(dto.getMpw());
					break;
				}
			}
		}
		else if(dto.getCondition().equals("CHECK")) {
			for(int i=0;i<this.datas.size();i++) {
				if(dto.getMid().equals(this.datas.get(i).getMid())) {
					data=new model.MemberDTO();
					break;
				}
			}
		}
		return data;
	}

	public boolean insert(model.MemberDTO dto) {
		try {
			model.MemberDTO data=new model.MemberDTO();
			data.setMid(dto.getMid());
			data.setMpw(dto.getMpw());
			this.datas.add(data);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	private boolean update(model.MemberDTO dto) {
		return false;
	}
	private boolean delete(model.MemberDTO dto) {
		return false;
	}
}
