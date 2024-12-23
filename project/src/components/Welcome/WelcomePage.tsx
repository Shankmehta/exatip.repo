import React from 'react';
import { useNavigate } from 'react-router-dom';
import { GraduationCap } from 'lucide-react';

const WelcomePage = () => {
  const navigate = useNavigate();

  return (
    <div className="min-h-screen bg-gradient-to-br from-[#ff7e5f] to-[#feb47b] flex flex-col items-center justify-center">
      <h1 className="text-4xl font-bold text-black mb-8"> Student Report Project using Rest</h1>
      
      <div 
        onClick={() => navigate('/student/login')}
        className="cursor-pointer transform hover:scale-110 transition-transform duration-300"
      >
        <div className="bg-white p-8 rounded-full shadow-lg mb-6">
          <GraduationCap size={100} className="text-[#ff7e5f]" />
        </div>
      </div>

      <div className="text-center">
        <button
          onClick={() => navigate('/student/login')}
          className="text-2xl text-white hover:text-yellow-300 transition-colors duration-300 font-bold"
        >
          Get Student Report
        </button>
      </div>
    </div>
  );
};

export default WelcomePage;