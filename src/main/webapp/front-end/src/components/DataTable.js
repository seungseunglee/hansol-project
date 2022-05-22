import { useEffect, useState } from 'react';
import { DataGrid } from '@mui/x-data-grid';

const DataTable = ({setSelected, data}) => {

  const [rows, setRows] = useState([]);
  
  const columns = [
    { field: 'id', headerName: '사번', flex: 1 },
    { field: 'workCode', headerName: '업무코드', flex: 2 },
    { field: 'workName', headerName: '업무명', flex: 3 },
    { field: 'company', headerName: '회사', flex: 2 },
    { field: 'empName', headerName: '담당자', flex: 2 },
    { field: 'position', headerName: '직급', flex: 1 },
    { field: 'task', headerName: '종류', flex: 4, sortable: false },
    { field: 'telephone', headerName: '전화번호', flex: 2, sortable: false },
  ];

  useEffect(() => {
    setRows([]);

    data.map(({empId, workCode, workName, company, empName, position, task, telephone}) => {
      setRows((prevState) => [
        ...prevState,
        {
          id: empId,
          workCode: workCode,
          workName: workName,
          company: company,
          empName: empName,
          position: position,
          task: task,
          telephone: telephone
        }]
      );
    });

  }, [data]);

  return (
    <div style={{ height: 530, width: '70%' }}>
      <DataGrid
        getRowId={(row) => row.id}
        rows={rows}
        columns={columns}
        pageSize={8}
        rowsPerPageOptions={[10]}
        checkboxSelection
        onSelectionModelChange={(selected) => {
          setSelected(selected);
        }}
      />
    </div>
  );
}

export default DataTable;