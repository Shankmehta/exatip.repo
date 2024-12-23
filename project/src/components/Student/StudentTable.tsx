import React from 'react';
import { Student } from '../../types/student';
import { ArrowUp, ArrowDown, Edit, Trash2 } from 'lucide-react';

interface StudentTableProps {
  students: Student[];
  onSort: (field: string, order: 'asc' | 'desc') => void;
  onEdit: (sno: number) => void;
  onDelete: (sno: number) => void;
}

const StudentTable: React.FC<StudentTableProps> = ({
  students,
  onSort,
  onEdit,
  onDelete,
}) => {
  const SortButtons = ({ field }: { field: string }) => (
    <div className="flex flex-col gap-1 items-center">
      <button onClick={() => onSort(field, 'asc')} className="hover:text-blue-600">
        <ArrowUp size={16} />
      </button>
      <button onClick={() => onSort(field, 'desc')} className="hover:text-blue-600">
        <ArrowDown size={16} />
      </button>
    </div>
  );

  return (
    <table className="min-w-full">
      <thead className="bg-gray-100">
        <tr>
          <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            <div className="flex items-center gap-2">
              Student No
              <SortButtons field="sno" />
            </div>
          </th>
          <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            <div className="flex items-center gap-2">
              Name
              <SortButtons field="sname" />
            </div>
          </th>
          <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            Address
          </th>
          <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            <div className="flex items-center gap-2">
              Fees
              <SortButtons field="fees" />
            </div>
          </th>
          <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
            Actions
          </th>
        </tr>
      </thead>
      <tbody className="bg-white divide-y divide-gray-200">
        {students.map((student) => (
          <tr key={student.sno} className="hover:bg-gray-50">
            <td className="px-6 py-4 whitespace-nowrap">{student.sno}</td>
            <td className="px-6 py-4 whitespace-nowrap">{student.sname}</td>
            <td className="px-6 py-4 whitespace-nowrap">{student.saddress}</td>
            <td className="px-6 py-4 whitespace-nowrap">{student.fees}</td>
            <td className="px-6 py-4 whitespace-nowrap">
              <div className="flex gap-3">
                <button
                  onClick={() => onEdit(student.sno)}
                  className="text-blue-600 hover:text-blue-800"
                >
                  <Edit size={20} />
                </button>
                <button
                  onClick={() => onDelete(student.sno)}
                  className="text-red-600 hover:text-red-800"
                >
                  <Trash2 size={20} />
                </button>
              </div>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default StudentTable;