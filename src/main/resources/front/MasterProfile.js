import React, { useState, useEffect } from 'react';
import axios from 'axios';

function MasterProfile({ masterId }) {
    const [services, setServices] = useState([]);
    const [selectedService, setSelectedService] = useState(null);
    const [bookingTime, setBookingTime] = useState('');

    useEffect(() => {
        axios.get(`/api/masters/${masterId}/services`)
            .then(response => setServices(response.data))
            .catch(error => console.log(error));
    }, [masterId]);

    const handleBooking = async () => {
        try {
            await axios.post('/api/bookings/create', {
                service: selectedService,
                bookingTime,
                phoneNumber: localStorage.getItem('user').phoneNumber,
            });
            alert("Booking successful");
        } catch (error) {
            alert("Booking failed");
        }
    };

    return (
        <div>
            <h2>Master Profile</h2>
            <select onChange={(e) => setSelectedService(e.target.value)}>
                {services.map(service => (
                    <option key={service.id} value={service.id}>
                        {service.name} - {service.price}$
                    </option>
                ))}
            </select>
            <input
                type="datetime-local"
                value={bookingTime}
                onChange={(e) => setBookingTime(e.target.value)}
            />
            <button onClick={handleBooking}>Book</button>
        </div>
    );
}

export default MasterProfile;